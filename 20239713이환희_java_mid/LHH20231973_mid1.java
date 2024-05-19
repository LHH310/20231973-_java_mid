import java.util.Random;
import java.util.Scanner;

public class LHH20231973_mid1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] choices = {"가위", "바위", "보"};
        
        System.out.println("가위바위보 게임을 시작합니다");
        System.out.println("가위/바위/보 중에 선택하세요.");
         
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
            
    if (userChoice == computerChoice) {
        	System.out.println("비겼습니다.");
            return;
        } else if ((userChoice == 0 && computerChoice == 2) || 
                   (userChoice == 1 && computerChoice == 0) ||
                   (userChoice == 2 && computerChoice == 1)) {
            System.out.println("사용자가 이겼습니다!");
            return;
        } else {
            System.out.println("컴퓨터가 이겼습니다!");
            return;
        }
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
