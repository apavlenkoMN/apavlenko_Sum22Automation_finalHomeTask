package com.provectus.tests;


import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.selenidePages.DownloadFilePageSelenide;
import pages.selenidePages.UploadFilePageSelenide;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SelenideTest {

    String theFileName = "";

  //  @Test(timeOut = 100)
    @Test(description = "download file", priority = 10)
    public void DownloadFile() throws InterruptedException, IOException {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";


           // new DownloadFilePageSelenide().open();

           // Selenide.open("https://the-internet.herokuapp.com/download");


            DownloadFilePageSelenide downloadPage = new DownloadFilePageSelenide();
            downloadPage.open();

            Assert.assertEquals(downloadPage.getPageTitle(), "File Downloader", "compare title");

            String fileName = downloadPage.getFileName();
            theFileName = fileName;

            downloadPage.downloadTXTFile();

        File file2 = new File("./src/test/resources/testing/"+theFileName);
        System.out.println(file2.getAbsolutePath());


        //FileWriter file = new FileWriter("./src/test/resources/testing/"+theFileName, true);
        FileWriter file = new FileWriter(file2, true);


        file.write("adding new text from the test2 \n");
        file.close();

        Assert.assertEquals(downloadPage.getPageTitle(), "File Downloader", "compare title");
    }


    @Test(description = "upload file", priority = 20)
    public void UploadFile(){

        UploadFilePageSelenide uploadFilePageSelenide = new UploadFilePageSelenide();
        uploadFilePageSelenide.open();


        Assert.assertEquals(uploadFilePageSelenide.getPageTitle(), "File Uploader", "compare title");

        //  uploadFilePage.upload("src/test/resources/testing/testFile.csv").getAbsolutePath();

        File file2 = new File("./src/test/resources/testing/"+theFileName);

       // uploadFilePageSelenide.upload("./src/test/resources/testing/" + theFileName);
        uploadFilePageSelenide.upload(file2.getAbsolutePath());
        Assert.assertEquals(uploadFilePageSelenide.getPageTitle(), "File Uploaded!", "compare title after upload");


    }

}
