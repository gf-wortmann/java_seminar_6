package org.example;

import java.util.*;

public class Main {
    public static void main ( String[] args ) {

        HashMap < Integer, String > colors = new HashMap <> ( );
        colors.put ( 0 , "red" );
        colors.put ( 1 , "blue" );
        colors.put ( 2 , "black" );
        colors.put ( 3 , "silver" );

        HashMap < Integer, String > OSs = new HashMap <> ( ) {{
            put ( 0 , "no OS" );
            put ( 1 , "DOS" );
            put ( 2 , "Linux" );
            put ( 3 , "Windows" );
            put ( 4 , "IOS" );
        }};

        HashMap < Integer, String > manufacturers = new HashMap <> ( ) {{
            put ( 0 , "Toshiba" );
            put ( 1 , "Huawei" );
            put ( 2 , "Acer" );
            put ( 3 , "Samsung" );
            put ( 4 , "Lenovo" );
        }};

        HashMap < Integer, Integer > RAMs = new HashMap <> ( ) {{
            put ( 0 , 8 );
            put ( 1 , 16 );
            put ( 2 , 32 );
            put ( 3 , 64 );
        }};
        HashMap < Integer, Integer > HDDs = new HashMap <> ( ) {{
            put ( 0 , 256 );
            put ( 1 , 512 );
            put ( 2 , 1024 );
            put ( 3 , 2048 );
        }};
        HashMap < Integer, String > params = new HashMap <> ( ) {{
            put ( 0 , "HDD" );
            put ( 1 , "RAM" );
            put ( 2 , "Price" );
        }};
        Object[] paramIndexes = params.keySet ( ).toArray ( );

        int notebooksCount = 10;
        List < NoteBook > noteBooks = new ArrayList <> ( );
        fillNotebooks ( colors , OSs , manufacturers , RAMs , HDDs , notebooksCount , noteBooks );

        Scanner sc = new Scanner ( System.in );
        for ( Object index : paramIndexes ) System.out.printf ( "%d  - %s\n" , (Integer) index , params.get ( index ) );
        System.out.println ( "Enter a parameter: " );
        Integer paramIndex = sc.nextInt ( );
        System.out.println ( "Enter a minimal value of the parameter: " );
        int paramIntMinValue = sc.nextInt ( );
        sc.close ( );

        for ( NoteBook notebook : noteBooks ) {
            if ( paramIntMinValue < (Integer) select ( notebook , params.get ( paramIndex ) ) ) {
                System.out.println ( notebook );
            }
        }

        System.out.println ( select ( noteBooks.get ( 1 ) , "HDD" ) );
    }

    private static void fillNotebooks ( HashMap < Integer, String > colors
            , HashMap < Integer, String > OSs
            , HashMap < Integer, String > manufacturers
            , HashMap < Integer, Integer > RAMs
            , HashMap < Integer, Integer > HDDs
            , int notebooksCount
            , List < NoteBook > noteBooks ) {
        for ( int i = 0 ; i < notebooksCount ; i++ ) {
            Random random = new Random ( );
            NoteBook noteBook = new NoteBook ( );
            noteBook.setColor ( colors.get ( random.nextInt ( 0 , colors.size ( ) ) ) );
            noteBook.setRAM_volume ( RAMs.get ( random.nextInt ( 0 , RAMs.size ( ) ) ) );
            noteBook.setHDD_volume ( HDDs.get ( random.nextInt ( 0 , HDDs.size ( ) ) ) );
            noteBook.setOS ( OSs.get ( random.nextInt ( 0 , OSs.size ( ) ) ) );
            noteBook.setManufacturer ( manufacturers.get ( random.nextInt ( 0 , manufacturers.size ( ) ) ) );
            noteBook.setPrice ( random.nextInt ( 1000 ) + 1000 );
            noteBooks.add ( noteBook );
        }
    }

    static Object select ( NoteBook object , String sign ) {
        HashMap < String, Object > params = new HashMap <> ( );
        params.put ( "Price" , object.getPrice ( ) );
        params.put ( "RAM" , object.getRAM_volume ( ) );
        params.put ( "HDD" , object.getHDD_volume ( ) );
        return params.get ( sign );
    }

}