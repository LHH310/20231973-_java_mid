import java.util.Random;
import java.util.Scanner;

public class LHH20231973_mid2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"가위", "바위", "보"};
        
        System.out.println("가위바위보 게임을 시작합니다");
        System.out.println("가위/바위/보 중에 선택하세요.");
        
        int previousWinner = -1; 
        
        while (true) {
            System.out.print("선택: ");
            String userInput = scanner.nextLine();
            int userChoice = convertChoice(userInput);
            int computerChoice = random.nextInt(3);
            
            if (userChoice == -1) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            
            System.out.println("사용자: " + choices[userChoice]);
            System.out.println("컴퓨터: " + choices[computerChoice]);
            
            
            if (previousWinner == -1) {
                previousWinner = decideWinner(userChoice, computerChoice);
            } else {
                if (userChoice == computerChoice) {
                    if (previousWinner == 0) {
                        System.out.println("사용자가 승리했습니다!");
                    } else {
                        System.out.println("컴퓨터가 승리했습니다!");
                    }
                    break;
                } else {
                    previousWinner = decideWinner(userChoice, computerChoice);
                }
            }
        }
        
        scanner.close();
    }

    public static int decideWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
        	System.out.println("비겼습니다. 다시 입력해주세요.");
            return -1;
        } else if ((userChoice == 0 && computerChoice == 2) || 
                   (userChoice == 1 && computerChoice == 0) ||
                   (userChoice == 2 && computerChoice == 1)) {
            System.out.println("사용자가 이겼습니다! 공격하세요.");
            return 0;
        } else {
            System.out.println("컴퓨터가 이겼습니다! 방어하세요.");
            return 1;
        }
    }
    
    public static int convertChoice(String userInput) {
        switch (userInput) {
            case "가위":
                return 0;
            case "바위":
                return 1;
            case "보":
                return 2;
            default:
                return -1;
        }
    }
}
