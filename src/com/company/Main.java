package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    private BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
    private List<String> names = new ArrayList<>();
    private List<String> deserializedNames = null;
    public static void main(String[] args) {

        Main main = new Main();

        try {
            main.performProgramLogic();
        } catch (Exception e){
            e.printStackTrace();
        }

    }


    private void getUserInput() throws Exception{

        for(int i = 0; i <10; i++){
            System.out.println("Podaj "+ (i+1) + " imię: ");
            names.add(userInputReader.readLine());
        }
    }


    private void saveNamesListToFile() throws Exception{

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("names.bin")))){

            objectOutputStream.writeObject(names);
        }
    }

    private void readNamesListFromFile() throws Exception {


        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("names.bin")))){

            deserializedNames = (ArrayList<String>)objectInputStream.readObject();
        }
    }


    private void performProgramLogic() throws Exception{


        getUserInput();

        saveNamesListToFile();

        readNamesListFromFile();


        System.out.println(deserializedNames);



    }
}
