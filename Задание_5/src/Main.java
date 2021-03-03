import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<Gamer> GameWinner = new ArrayList<>();

        for (Gamer g: GamerArray) {
            int gscore = 0;
            Gamer prevgamer = new Gamer(g.getName(),g.getScore(),g.getIs_winnner());
            for (Gamer w: GamerArray) {
                if ((w.getName().equals(g.getName())) & !w.getIs_winnner()) {
                    gscore += w.getScore();
                    w.setIs_winnner(true);
                }
            }
             prevgamer.setScore(gscore);
            if(!prevgamer.getIs_winnner())
                GameWinner.add(prevgamer);


        }
        String nameWinner = "";
        int scoreWinner = GameWinner.get(0).getScore();
        for (Gamer g: GameWinner) {
            if(scoreWinner < g.getScore()) {
                scoreWinner = g.getScore();
                nameWinner = g.getName();
            }
        }
        //System.out.println(nameWinner + " =  " + scoreWinner);
        return nameWinner;
    }

}
