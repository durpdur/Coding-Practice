package com.ian;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App 
{
    public static void main( String[] args ) throws IOException {

        Document doc = Jsoup.connect("https://www.allrecipes.com/recipe/284164/beef-tips-and-tots/").get();

        List<DishName> dishes = new ArrayList<>();
        Elements h1Elements = doc.getElementsByTag("h1");
        // System.out.println(h1Elements);

        for (Element dishNames: h1Elements) {
            // System.out.println(dishNames);
            DishName dishName = new DishName();
            // System.out.println(dishNames.text());

            String name = dishNames.text();

            dishName.setName(name);

            dishes.add(dishName);
        }

        File csvFile = new File("output.csv");

        try (PrintWriter printWriter = new PrintWriter(csvFile)) {
            for (DishName dishName : dishes) {
                List<String> row = new ArrayList<>();

                row.add("\\" + dishName.getName() + "\\");

                printWriter.println(String.join(",", row));
            }
        }
    }
    
}
