package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many zeros the hash must start with: ");
        int numOfZeros = Integer.parseInt(scanner.nextLine());
        BlockChain chain = new BlockChain(numOfZeros);
        chain.displayChain();
    }
}
