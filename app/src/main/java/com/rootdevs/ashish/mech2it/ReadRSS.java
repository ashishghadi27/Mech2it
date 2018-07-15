package com.rootdevs.ashish.mech2it;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import Adapter.FeedAdapter;
import Model.Feed;

public class ReadRSS extends AsyncTask<Void, Void, Void> {
    Context context;
    String address;
    ProgressDialog progressDialog;
    ArrayList<Feed> feedItems;
    RecyclerView recyclerView;
    URL url;
    public int count = 0;

    public ReadRSS(Context context, RecyclerView recyclerView) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("rss",Context.MODE_PRIVATE);
        address = sharedPreferences.getString("link","http://www.sciencemag.org/rss/news_current.xml");
        this.recyclerView = recyclerView;
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
    }

    
    @Override
    protected void onPreExecute() {
        progressDialog.show();
        super.onPreExecute();
    }


   
    @Override
    protected Void doInBackground(Void... params) {
        
        ProcessXml(Getdata());

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        FeedAdapter adapter = new FeedAdapter(context, feedItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        if(count == 0){
            recyclerView.addItemDecoration(new VerticalSpace(10));
        }
        recyclerView.setAdapter(adapter);

    }


    private void ProcessXml(Document data) {
        if (data != null) {
            feedItems = new ArrayList<>();
            Element root = data.getDocumentElement();
            Node channel = root.getChildNodes().item(1);
            NodeList items = channel.getChildNodes();
            for (int i = 0; i < items.getLength(); i++) {
                Node cureentchild = items.item(i);
                if (cureentchild.getNodeName().equalsIgnoreCase("item")) {
                    Feed item = new Feed();
                    NodeList itemchilds = cureentchild.getChildNodes();
                    for (int j = 0; j < itemchilds.getLength(); j++) {
                        Node cureent = itemchilds.item(j);
                        if (cureent.getNodeName().equalsIgnoreCase("title")) {
                            item.setTitle(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("description")) {
                            item.setDescription(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("pubDate")) {
                            item.setPubDate(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("link")) {
                            item.setLink(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("media:thumbnail")) {
                            //this will return us thumbnail url
                            String url = cureent.getAttributes().item(0).getTextContent();
                            item.setThumbnailUrl(url);
                        }
                    }
                    feedItems.add(item);


                }
            }
        }
    }

    
    public Document Getdata() {
        try {
            url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDoc = builder.parse(inputStream);
            return xmlDoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

