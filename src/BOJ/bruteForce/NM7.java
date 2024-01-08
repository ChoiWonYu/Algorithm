    package BOJ.bruteForce;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class NM7 {

        static int[] nums, print;
        static int n, m;
        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            nums = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);

            print = new int[m];

            dfs(0);

            System.out.println(sb);
        }

        private static void dfs(final int depth) {

            if (depth == m) {
                for (int i : print) {
                    sb.append(i).append(" ");
                }
                sb.append("\n");
                return;
            }

            for (int i = 0; i < n; i++) {
                print[depth] = nums[i];
                dfs(depth + 1);
            }
        }

    }
