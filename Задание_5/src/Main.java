import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Задание 5 Необходимо написать функцию, которая на вход получает массив строк, в формате имя_игрока количество_очков.
//	Необходимо вывести победителя данной игры.
public class Main {
    public static ArrayList<Gamer> GamerArray;
    public static void main(String[] args) throws IOException {
        //Чтение строки их файла game.txt
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader("game.txt"))) {
                String bufferString = "";
                ArrayList<String> gamers = new ArrayList<>();
                System.out.println("Массив Игроков");
                while ((bufferString = bufferedReader.readLine()) != null) {
                    String[] gamer = bufferString.split(",");
                    Collections.addAll(gamers, gamer);
                    System.out.println(bufferString);
                }
                System.out.println("Победитель = " + winner(gamers.toArray(String[]::new)));
            } catch (IOException e) {
                e.printStackTrace();
            }

     }
// функцию, которая на вход получает массив строк, выводит победителя данной игры
    public static String winner(String[] gamer){
        GamerArray = new ArrayList<>();
        for (String a:gamer) {
            String[] gam = a.split(" ");
                int score = Integer.parseInt(gam[1]);
                String name = gam[0];
                GamerArray.add(new Gamer(name, score, false));
        }

        Map<String, List<Integer>> GameWinner = new HashMap<>();

        for (Gamer g: GamerArray) {
            int gscore = 0;
            Gamer prevgamer = new Gamer(g.getName(),g.getScore(),g.getIs_winnner());
            List<Integer> Scorers = new ArrayList<>();
            for (Gamer w: GamerArray) {
                if ((w.getName().equals(g.getName())) & !w.getIs_winnner()) {
                    Scorers.add(w.getScore());
                    w.setIs_winnner(true);
                }
            }
             //prevgamer.setScore(gscore);
            if(!prevgamer.getIs_winnner())
                GameWinner.put(prevgamer.getName(),Scorers);
        }
        String nameWinner = GamerArray.get(0).getName();
        int scoreWinner = GameWinner.get(nameWinner).get(0);
        int i = 0;
        int length = GameWinner.get(nameWinner).size();
        while (i < length) {
            for (Map.Entry<String, List<Integer>> e : GameWinner.entrySet()) {
                String name = e.getKey();
                List<Integer> score = e.getValue();
                if (scoreWinner < score.get(i)) {
                    scoreWinner = score.get(i);
                    nameWinner = name;

                }
            }
            i++;
        }
        System.out.println(nameWinner + " =  " + scoreWinner);
        return nameWinner;
    }

}
