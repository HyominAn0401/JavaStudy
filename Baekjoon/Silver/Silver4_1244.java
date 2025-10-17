package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver4_1244 {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            int [] switches = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                switches[i] = Integer.parseInt(st.nextToken());
            }

            int students = Integer.parseInt(br.readLine());
            for(int i=0; i<students; i++){
                st = new StringTokenizer(br.readLine());
                int gender = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());

                // 남학생
                if(gender==1){
                    applyBoy(switches, N, number);
//                    int cnt = N/number;
//                    for(int j=1; j<=cnt; j++){
//                        if(switches[number * j]==0)
//                            switches[number * j]=1;
//                        else if(switches[number * j]==1)
//                            switches[number * j]=0;
//                    }
                }

                // 여학생
                else if(gender==2){
                    applyGirl(switches, N, number);
//                    if(number==1 || number==N){
//                        if(switches[number]==0)
//                            switches[number]=1;
//                        else if(switches[number]==1)
//                            switches[number]=0;
//                    }
//                    else{
//                        int num = number;
//                        int left = num -1;
//                        int right = num + 1;
//                        boolean isSym = true;
//                        if(switches[number]==0)
//                            switches[number]=1;
//                        else if(switches[number]==1)
//                            switches[number]=0;
//
//                        while(isSym){
//                            if(left > 0 && right <= N && switches[left]==switches[right]){
//                                if(switches[left]==0)
//                                    switches[left]=1;
//                                else if(switches[left]==1)
//                                    switches[left]=0;
//
//                                if(switches[right]==0)
//                                    switches[right]=1;
//                                else if(switches[right]==1)
//                                    switches[right]=0;
//                                left --;
//                                right ++;
//                            }
//                            else isSym = false;
//                        }
//                    }
                }
            }

//            if(N>20){
//                for(int i=1; i<=N; i++){
//                    System.out.print(switches[i]+" ");
//                    if(i%20==0){
//                        System.out.println();
//                    }
//                }
//            }
//            else{
//                for(int i=1; i<=N; i++){
//                    System.out.print(switches[i]+" ");
//                }
//            }
            printSwitches(switches);
        }
    }

    // 상태 변화
    private static void toggle(int[] sw, int i){
        sw[i] ^= 1;
    }

    // 남학생
    private static void applyBoy(int[] sw, int n, int k){
        for(int m=k; m<=n; m+=k)    toggle(sw, m);
    }

    // 여학생
    private static void applyGirl(int[] sw, int n, int k){
        // 중심
        toggle(sw, k);

        // 좌우대칭
        int left = k-1;
        int right = k+1;
        while(left >= 1 && right <= n && sw[left]==sw[right]){
            toggle(sw, left);
            toggle(sw, right);
            left--;
            right++;
        }
    }

    // 출력문
    private static void printSwitches(int[] sw){
        for(int i=1; i<sw.length; i++){
            System.out.print(sw[i]+" ");
            if(i%20==0) System.out.println();
        }
    }
}
