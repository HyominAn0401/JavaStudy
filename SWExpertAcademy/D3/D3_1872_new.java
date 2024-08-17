package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1872_new {
    static int x_index = 0, y_index = 0;
    static char tank = ' ';
    static int value=0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCase = Integer.parseInt(br.readLine());
            String [] result = new String[testCase];

            for (int t = 0; t < testCase; t++) {
                StringBuilder sb = new StringBuilder();

                StringTokenizer st = new StringTokenizer(br.readLine());
                int H = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                char[][] field = new char[H][M];

                for (int i = 0; i < H; i++) {
                    String str = br.readLine();
                    for (int j = 0; j < M; j++) {
                        field[i][j] = str.charAt(j);
                        if (field[i][j] == '<' || field[i][j] == '>' || field[i][j] == '^' || field[i][j] == 'v') {
                            x_index = i;
                            y_index = j;
                            tank = field[i][j];
                        }
                    }
                }

                int N = Integer.parseInt(br.readLine());
                String order = br.readLine();
                char[] orderChar = order.toCharArray();

//            for(int i=0; i<H; i++){
//                for(int j=0; j<M; j++){
//                    System.out.print(field[i][j]+" ");
//                }
//                System.out.println();
//            }
//
//            System.out.println();

                // 시작
                for (int i = 0; i < N; i++) {
                    switch (orderChar[i]) {
                        case 'U':
                            field[x_index][y_index] = '^';
                            tank = '^';
                            if (field[x_index - 1][y_index] == '.') {
                                char temp;
                                temp = field[x_index - 1][y_index];
                                field[x_index - 1][y_index] = field[x_index][y_index];
                                field[x_index][y_index] = temp;
                                x_index--;
                            }
                            break;
                        case 'D':
                            field[x_index][y_index] = 'v';
                            tank = 'v';
                            if (field[x_index + 1][y_index] == '.') {
                                char temp;
                                temp = field[x_index + 1][y_index];
                                field[x_index + 1][y_index] = field[x_index][y_index];
                                field[x_index][y_index] = temp;
                                x_index++;
                            }
                            break;
                        case 'L':
                            field[x_index][y_index] = '<';
                            tank = '<';
                            if (field[x_index][y_index - 1] == '.') {
                                char temp;
                                temp = field[x_index][y_index - 1];
                                field[x_index][y_index - 1] = field[x_index][y_index];
                                field[x_index][y_index] = temp;
                                y_index--;
                            }
                            break;
                        case 'R':
                            field[x_index][y_index] = '>';
                            tank = '>';
                            if (field[x_index][y_index + 1] == '.') {
                                char temp;
                                temp = field[x_index][y_index + 1];
                                field[x_index][y_index + 1] = field[x_index][y_index];
                                field[x_index][y_index] = temp;
                                y_index++;
                            }
                            break;
                        case 'S':
                            switch (tank) {
                                case '<':
                                    value = y_index - 1;
                                    while (value >= 0 && field[x_index][value] != '*' && field[x_index][value] != '#') {
                                        value--;
                                        //System.out.println("value: "+value);
                                    }
                                    if (value >= 0) {
                                        if (field[x_index][value] == '*')
                                            field[x_index][value] = '.';
                                    }
                                    value = 0;
                                    break;
                                case '>':
                                    value = y_index + 1;
                                    //System.out.println("value(y+1) : "+value);
                                    while (value < M && field[x_index][value] != '*' && field[x_index][value] != '#') {
                                        value++;
                                    }

                                    if (value < M) {
                                        if (field[x_index][value] == '*')
                                            field[x_index][value] = '.';
                                    }
                                    value = 0;
                                    break;
                                case 'v':
                                    value = x_index + 1;
                                    while (value < H && field[value][y_index] != '*' && field[value][y_index] != '#') {
                                        value++;
                                    }
                                    if (value < H) {
                                        if (field[value][y_index] == '*')
                                            field[value][y_index] = '.';
                                    }
                                    value = 0;
                                    break;
                                case '^':
                                    value = x_index - 1;
                                    while (value >= 0 && field[value][y_index] != '*' && field[value][y_index] != '#' && field[value][y_index] != '-') {
                                        value--;
                                    }
                                    if (value >= 0) {
                                        if (field[value][y_index] == '*')
                                            field[value][y_index] = '.';
                                    }
                                    value = 0;
                                    break;
                            }

                    }
//                System.out.println((i+1) + " "+orderChar[i]);
//                System.out.println(tank+" 위치 : "+x_index+", "+y_index);
//                for(int a=0; a<H; a++){
//                    for(int b=0; b<M; b++){
//                        System.out.print(field[a][b]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                }

                for (int i = 0; i < H; i++) {
                    for (int j = 0; j < M; j++) {
                        //System.out.print(field[i][j] + " ");
                        sb.append(field[i][j]);
                    }
                    sb.append("\n");
                }
                result[t] = sb.toString();
            }

            for(int t=0; t<testCase; t++){
                System.out.print("#"+(t+1)+" "+result[t]);
            }
        }
    }
}
