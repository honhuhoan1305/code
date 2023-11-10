package queens;

import java.util.*;

public class Node {
    public static final int N = 8;
    Queen[] state;

    public Node() {
        state = new Queen[N];
        generateBoard();

    }

    public Node(Queen[] state) {
        this.state = new Queen[N];
        for (int i = 0; i < state.length; i++) {
            this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
        }
    }

    public Node(Node n) {
        this.state = new Queen[N];
        for (int i = 0; i < N; i++) {
            Queen qi = n.state[i];
            this.state[i] = new Queen(qi.getRow(), qi.getColumn());
        }
    }

    public void generateBoard() {
        Random random  = new Random();
        for (int i = 0; i < N; i++) {
            state[i] = new Queen(random.nextInt(N), i);
        }
    }

    public int getH() {
        int heuristic = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (state[i].isConflict(state[j])) {
                    heuristic++;
                }
            }
        }

        return heuristic;
    }


    public List<Node> generateAllCandidates() {
        List<Node> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j != state[i].getRow()) {
                    Queen[] newState = Arrays.copyOf(state, N);
                    newState[i] = new Queen(j, state[i].getColumn());
                    result.add(new Node(newState));
                }
            }
        }

        return result;
    }


    public Node selectNextRandomCandidate() {
        List<Node> candidates = generateAllCandidates();
        Random random = new Random();
        return candidates.get(random.nextInt(candidates.size()));
    }


    public void displayBoard() {
        int[][] board = new int[N][N];
        // set queen position on the board
        for (int i = 0; i < N; i++) {
            board[state[i].getRow()][state[i].getColumn()] = 1;
        }
        // print board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q" + " ");
                } else {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
    }
}
