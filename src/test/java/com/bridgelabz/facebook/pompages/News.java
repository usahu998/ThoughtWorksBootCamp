//package com.bridgelabz.facebook.pompages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.*;
//
//import static com.bridgelabz.facebook.generic.IAutoConstant.CHROME_KEY;
//import static com.bridgelabz.facebook.generic.IAutoConstant.CHROME_VALUE;
////pict
//
//public class News {
//    public static void main(String[] args) {
//
//     //   System.setProperty(CHROME_KEY, CHROME_VALUE);
//       // WebDriver driver = new ChromeDriver();
//      //  driver.get("https://news.ycombinator.com/");
//      //  List<WebElement> newsHeading=driver.findElements(By.cssSelector("tr.athing a.storylink"));
//      //  List<WebElement> scoreHeading=driver.findElements(By.cssSelector("tr span.scoreHeading"));
//     //   List<String> newsHeading = new ArrayList<>();
//     //   List<String> scoreHeading = new ArrayList<>();
//
//        List<String> newsHeading=new ArrayList<String>(5);
//        newsHeading.add("The Rapid Growth of Io_using The ");
//        newsHeading.add("Before the DNS: how yours truly upstaged the NIC's official HOSTS.TXT (2004) dj");
//        newsHeading.add("How Andre Iguodala handled his rare NBA sabbatical in Silicon Valley");
//        newsHeading.add("Chip industry had worst sales year since dot-com bubble burst");
//        newsHeading.add("Apple’s independent repair program is invasive to shops and their customers ");
//
//        List<Integer> scoreHeading=new ArrayList<Integer>(5);
//        scoreHeading.add(1);
//        scoreHeading.add(2);
//        scoreHeading.add(3);
//        scoreHeading.add(4);
//        scoreHeading.add(5);
//
//
//
//        Map<String,Integer> newsAndScoreMap= new HashMap<>();
//        for (int i = 0; i <scoreHeading.size() ; i++) {
//            newsAndScoreMap.put(newsHeading.get(i),Integer.parseInt(scoreHeading.get(i)));
//
//       }
//
//
//
//
//
//        System.out.println(newsHeading);
//        System.out.println(scoreHeading);
//        System.out.println(listOfWord(newsHeading));
//
//
//        +        List<String> arrayOfWords = listOfWord(newsHeading);
//        String arr[] =new String[arrayOfWords.size()];
//        for(int i=0;i<arrayOfWords.size();i++)
//        {
//           arr[i]=arrayOfWords.get(i);
//        }
//        System.out.println(findWord(arr));
//      //  countWord(newsHeading);
//
//     //   driver.close();
//
//    }
//
//
//
//    static List<String> listOfWord(List<String> newsHeading)
//    {
//        List<String> listOfWords= new ArrayList<>();
//        for (String news: newsHeading) {
//            String[] arrOfString=news.split(" ");
//            List<String> l1=Arrays.asList(arrOfString);
//            listOfWords.addAll(l1);
//        }
//       // System.out.println(listOfWords);
//        return listOfWords;
//    }
//
//
//    static String findWord(String[] arr)
//    {
//
//        // Create HashMap to store word and it's frequency
//        HashMap<String, Integer> hs = new HashMap<String, Integer>();
//
//        // Iterate through array of words
//        for (int i = 0; i < arr.length; i++) {
//            // If word already exist in HashMap then increase it's count by 1
//            if (hs.containsKey(arr[i])) {
//                hs.put(arr[i], hs.get(arr[i]) + 1);
//            }
//            // Otherwise add word to HashMap
//            else {
//                hs.put(arr[i], 1);
//            }
//        }
//
//        // Create set to iterate over HashMap
//        Set<Map.Entry<String, Integer> > set = hs.entrySet();
//        String key = "";
//        int value = 0;
//
//        for (Map.Entry<String, Integer> me : set) {
//            // Check for word having highest frequency
//            if (me.getValue() > value) {
//                value = me.getValue();
//                key = me.getKey();
//            }
//        }
//        return key;
//    }
//
//
//    public static String getPopularNewsHeading(Map<String, Integer> mapData, String mostOccuredWord) {
//        int value = 0;
//        String mostPopular="";
//        for (Map.Entry<String, Integer> val : mapData.entrySet()) {
//            if (val.getKey().contains(mostOccuredWord )) {
//                if ( val.getValue()>value){
//                    value=val.getValue();
//                    mostPopular=val.getKey();
//                }
//            }
//
//        }
//        System.out.println("Most populaR TEST DATA:"+mostPopular);
//        return mostPopular;
//    }
//    getPopularNewsHeading();
//
//
//}
