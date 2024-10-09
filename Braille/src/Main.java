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






    static HashMap<String, Character> alfabetMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> lijn = new ArrayList<>(3);

        leesLijn(sc, lijn);

        alfabetMap = maakAlfabetMap(lijn);

        int aantalTestGevallen = Integer.parseInt(sc.nextLine());

        for (int a = 1; a <= aantalTestGevallen; a++) {
            lijn.clear();

            leesLijn(sc, lijn);

            StringBuilder zin = new StringBuilder();

            for (int i = 0; i < lijn.getFirst().length() / 2; i++) {
                StringBuilder code = new StringBuilder();

                for (String s : lijn) {
                    code.append(s, 2 * i, 2 * (i + 1));
                }
                zin.append(alfabetMap.get(code.toString()));
            }
            System.out.println(a + " " + zin);
        }
        sc.close();
    }

    static void leesLijn(Scanner sc, ArrayList<String> lijn) {
        for (int i = 0; i < 3; i++) {
            lijn.add(sc.nextLine());
        }
    }

    static HashMap<String, Character> maakAlfabetMap(ArrayList<String> lijn) {
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        HashMap<String, Character> alfabetMap = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            StringBuilder code = new StringBuilder();

            for (int j = 0; j < 3; j++) {
                code.append(lijn.get(j), 2 * i, 2 * (i + 1));
            }
            alfabetMap.put(code.toString(), alfabet.charAt(i));
        }
        return alfabetMap;
    }
}