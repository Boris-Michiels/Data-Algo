import java.util.*;

public class Main {
    private static final int[][] richtingen = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aantalTestGevallen = Integer.parseInt(sc.nextLine());

        for (int a = 1; a <= aantalTestGevallen; a++) {
            int hoogte = Integer.parseInt(sc.nextLine());
            int breedte = Integer.parseInt(sc.nextLine());

            char[][] kaart = new char[hoogte][breedte];

            for (int i = 0; i < hoogte; i++) {
                String lijn = sc.nextLine();

                for (int j = 0; j < breedte; j++) {
                    kaart[i][j] = lijn.charAt(j);
                }
            }

            List<Integer> eilanden = telEilanden(kaart, hoogte, breedte);
            Map<Integer, Integer> telGroottes = new TreeMap<>();

            for (int grootte : eilanden) {
                telGroottes.put(grootte, telGroottes.getOrDefault(grootte, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            sb.append(a);

            for (int grootte : telGroottes.keySet()) {
                sb.append(" ").append(grootte).append(" ").append(telGroottes.get(grootte));
            }

            System.out.println(sb);
        }

        sc.close();
    }

    public static ArrayList<Integer> telEilanden(char[][] kaart, int hoogte, int breedte) {
        boolean[][] bezocht = new boolean[hoogte][breedte];
        ArrayList<Integer> eilanden = new ArrayList<>();

        for (int i = 0; i < hoogte; i++) {
            for (int j = 0; j < breedte; j++) {
                if (kaart[i][j] == '+' && !bezocht[i][j]) {
                    int grootte = verkenEiland(kaart, bezocht, i, j, hoogte, breedte);
                    eilanden.add(grootte);
                }
            }
        }

        return eilanden;
    }

    private static int verkenEiland(char[][] kaart, boolean[][] bezocht, int x, int y, int hoogte, int breedte) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        bezocht[x][y] = true;
        int grootte = 0;

        while (!stack.isEmpty()) {
            int[] positie = stack.pop();
            grootte++;

            for (int[] r : richtingen) {
                int[] nieuwePositie = {positie[0] + r[0], positie[1] + r[1]};

                if (nieuwePositie[0] >= 0 && nieuwePositie[0] < hoogte && nieuwePositie[1] >= 0 && nieuwePositie[1] < breedte
                        && !bezocht[nieuwePositie[0]][nieuwePositie[1]]
                        && kaart[nieuwePositie[0]][nieuwePositie[1]] == '+') {
                    stack.push(nieuwePositie);
                    bezocht[nieuwePositie[0]][nieuwePositie[1]] = true;
                }
            }
        }

        return grootte;
    }
}
