package downloader;

import observer.DownloadPorcentage;
import observer.Observer;
import observer.Subject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class Downloader implements Runnable{

    public String[] pages;
    private DownloadPorcentage downloadPorcentage;
    private Subject subject;

    public Downloader(String[] pages){
        this.pages = pages;
    }

    public String[] getPages() {
        return pages;
    }

    @Override
    public void run() {
        try{
            this.subject = new Subject();
            this.downloadPorcentage = new DownloadPorcentage(subject);

            for (String page : pages){
                URL url = new URL(page);
                HttpURLConnection httpURLConnection = (HttpURLConnection) (url.openConnection());
                long fileSize = httpURLConnection.getContentLength();

                BufferedInputStream input = new BufferedInputStream(httpURLConnection.getInputStream());
                String filename = page.substring(page.lastIndexOf("/")+1).trim();
                FileOutputStream output = new FileOutputStream(filename);
                BufferedOutputStream otp = new BufferedOutputStream(output,1024);
                byte[] data = new byte[1024];
                long dataDownloaded = 0;
                int x = 0;
                while ((x=input.read(data,0,1024))>=0){
                    dataDownloaded += x;
                    final int currentProgress = (int)((((double)dataDownloaded)/((double) fileSize))*100d);
                    subject.setStatus("Descargando: " + filename + " " + currentProgress + "%");
                }
                otp.close();
                input.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
