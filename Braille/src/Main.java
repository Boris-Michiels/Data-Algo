import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    /*static String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static HashMap<Integer, Character> alfabetMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] alfabetArray = new int[26];
        String lijn;

        for (int i = 0; i < 3; i++) {
            lijn = sc.nextLine();
            for (int j = 0; j < 26; j++) {
                int letter = alfabetArray[j];
                for (int k = 0; k < 2; k++) {
                    letter *= 2;
                    if (lijn.charAt(2*j + k) == '.') letter++;
                }
                alfabetArray[j] = letter;
            }
        }
        // Zet de array om in een hashmap
        for (int i = 0; i < alfabetArray.length; i++) {
            alfabetMap.put(alfabetArray[i], alfabet.charAt(i));
        }

        int aantalTestGevallen = Integer.parseInt(sc.nextLine());

        for (int a = 1; a <= aantalTestGevallen; a++) {
            String testLijn;
            ArrayList<Integer> integerLijst = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                testLijn = sc.nextLine();
                int aantalLetters = testLijn.length() / 2;

                for (int j = 0; j < aantalLetters; j++) {
                    int letter = 0;
                    if (i != 0) letter = integerLijst.get(j);
                    for (int k = 0; k < 2; k++) {
                        letter *= 2;
                        if (testLijn.charAt(2*j + k) == '.') letter++;
                    }
                    if (i == 0) integerLijst.add(letter);
                    else integerLijst.set(j, letter);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a).append(" ");
            for (int waarde : integerLijst) {
                stringBuilder.append(alfabetMap.get(waarde));
            }

            System.out.println(stringBuilder);

        }
        sc.close();
    }*/






    static HashMap<Integer, Character> alfabetMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> lijn = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            lijn.add(sc.nextLine());
        }

        alfabetMap = maakAlfabetMap(lijn);

        int aantalTestGevallen = Integer.parseInt(sc.nextLine());

        for (int a = 1; a <= aantalTestGevallen; a++) {
            lijn.clear();

            for (int i = 0; i < 3; i++) {
                lijn.add(sc.nextLine());
            }

            int[] integerZin = new int[lijn.getFirst().length() / 2];

            for (int i = 0; i < integerZin.length; i++) {
                int code = 0;

                for (String s : lijn) {
                    for (int k = 0; k < 2; k++) {
                        code *= 2;
                        if (s.charAt(2 * i + k) == '.') code++;
                    }
                }
                integerZin[i] = code;
            }
            System.out.println(a + " " + converteerIntegerZinNaarKarakterZin(integerZin));
        }
        sc.close();
    }

    static String converteerIntegerZinNaarKarakterZin(int[] integerZin) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int code : integerZin) {
            stringBuilder.append(alfabetMap.get(code));
        }
        return stringBuilder.toString();
    }

    static HashMap<Integer, Character> maakAlfabetMap(ArrayList<String> lijn) {
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<Integer, Character> alfabetMap = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            int code = 0;

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    code *= 2;
                    if (lijn.get(j).charAt(i*2 + k) == '.') code++;
                }
            }
            alfabetMap.put(code, alfabet.charAt(i));
        }
        return alfabetMap;
    }
}