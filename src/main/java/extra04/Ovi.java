package extra04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Ovi {

    private static List<Byte> goals = new ArrayList<>();

    public static void main(String[] args) {
        Byte[] currentGoals = new Byte[] {0, 0, 0, 1, 0, 1, 0, 2, 1, 1, 1, 1, 0, 2, 0, 0, 3, 2, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 3, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1};
        List<Byte> list = List.of(currentGoals);
        goals.addAll(list);
        System.out.println(Arrays.toString(lastWorstEpisode(5)));
        System.out.println(Arrays.toString(lastWorstEpisode(59)));
        System.out.println(Arrays.toString(lastBestEpisode(5)));
        System.out.println(Arrays.toString(lastBestEpisode(59)));
        System.out.println(averageResult());
        System.out.println(Arrays.toString(longestBadEpisode((byte) 2)));
    }

    private static byte[] lastWorstEpisode(int games) {
        if(games > goals.size()) {
            throw new IllegalArgumentException();
        }
        byte[] worstRes = new byte[2];
        byte temp = 0;
        int ind = 0;
        for(int i = 0; i < games; i++) {
            temp += goals.get(i);
        }
        worstRes[1] = temp;
        for(int i = games; i < goals.size(); i++) {
            temp += goals.get(i);
            temp -= goals.get(i - games);
            if(temp <= worstRes[1]) {
                worstRes[1] = temp;
                ind = i - games;
            }
        }
        worstRes[0] = (byte)++ind;
        return worstRes;
    }

    private static byte[] lastBestEpisode(int games) {
        if(games > goals.size()) {
            throw new IllegalArgumentException();
        }
        byte[] bestRes = new byte[2];
        byte temp = 0;
        int ind = 0;
        for(int i = 0; i < games; i++) {
            temp += goals.get(i);
        }
        bestRes[1] = temp;
        for(int i = games; i < goals.size(); i++) {
            temp += goals.get(i);
            temp -= goals.get(i - games);
            if(temp >= bestRes[1]) {
                bestRes[1] = temp;
                ind = i - games;
            }
        }
        bestRes[0] = (byte)++ind;
        return bestRes;
    }

    private static byte[] longestBadEpisode(byte goal) {
        byte[] badEpisode = new byte[2];
        byte temp = 0;
        byte currentEpisode = 0;
        for(int i = 0; i < goals.size(); i++) {
            currentEpisode++;
            temp += goals.get(i);
            if(temp > goal) {
                for(int j = i - currentEpisode; j <= i & temp > goal; j++) {
                    temp -= goals.get(j + 1);
                }
            }
            if (temp == goal && currentEpisode >= badEpisode[0]) {
                badEpisode[0] = (byte) (i - currentEpisode);
                badEpisode[1] = currentEpisode;
            }
        }
        return badEpisode;
    }

    private static double averageResult() {
        int sum = 0;
        for (byte b :
             goals) {
            sum += b;
        }
        int temp = 100 * sum / goals.size();
        return (double) temp / 100;
    }


}
