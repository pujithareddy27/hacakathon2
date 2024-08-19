import java.util.*;

class Question {
    String state;
    String[] options = new String[4];
    String correctAnswer;

    public Question(String state, String[] options, String correctAnswer) {
        this.state = state;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class Quiz {
    List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int conductQuiz() {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        
        for (Question q : questions) {
            System.out.println("What is the capital of " + q.state + "?");
            for (int i = 0; i < q.options.length; i++) {
                System.out.println((i + 1) + ": " + q.options[i]);
            }

            System.out.print("Enter correct option: ");
            int answerIndex = sc.nextInt() - 1;

            if (answerIndex >= 0 && answerIndex < 4 && q.checkAnswer(q.options[answerIndex])) {
                score++;
            }
        }
        return score;
    }
}

class Student {
    String id;
    int score;

    public Student(String id) {
        this.id = id;
    }

    public void takeQuiz(Quiz quiz) {
        score = quiz.conductQuiz();
    }

    public void displayScore() {
        System.out.println("Student ID: " + id + " | Score: " + score);
    }
}

public class QuizCompetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Quiz quiz = new Quiz();

        // List of states and their capitals
        Map<String, String> statesAndCapitals = new HashMap<>();
        statesAndCapitals.put("Andhra Pradesh", "Amaravati");
        statesAndCapitals.put("Arunachal Pradesh", "Itanagar");
        statesAndCapitals.put("Assam", "Dispur");
        statesAndCapitals.put("Bihar", "Patna");
        statesAndCapitals.put("Chhattisgarh", "Raipur");
        statesAndCapitals.put("Goa", "Panaji");
        statesAndCapitals.put("Gujarat", "Gandhinagar");
        statesAndCapitals.put("Haryana", "Chandigarh");
        statesAndCapitals.put("Himachal Pradesh", "Shimla");
        statesAndCapitals.put("Jharkhand", "Ranchi");
        statesAndCapitals.put("Karnataka", "Bangalore");
        statesAndCapitals.put("Kerala", "Thiruvananthapuram");
        statesAndCapitals.put("Madhya Pradesh", "Bhopal");
        statesAndCapitals.put("Maharashtra", "Mumbai");
        statesAndCapitals.put("Manipur", "Imphal");
        statesAndCapitals.put("Meghalaya", "Shillong");
        statesAndCapitals.put("Mizoram", "Aizawl");
        statesAndCapitals.put("Nagaland", "Kohima");
        statesAndCapitals.put("Odisha", "Bhubaneshwar");
        statesAndCapitals.put("Punjab", "Chandigarh");
        statesAndCapitals.put("Rajasthan", "Jaipur");
        statesAndCapitals.put("Sikkim", "Gangtok");
        statesAndCapitals.put("Tamil Nadu", "Chennai");
        statesAndCapitals.put("Telangana", "Hyderabad");
        statesAndCapitals.put("Tripura", "Agartala");
        statesAndCapitals.put("Uttarakhand", "Dehradun");
        statesAndCapitals.put("Uttar Pradesh", "Lucknow");
        statesAndCapitals.put("West Bengal", "Kolkata");

        // Prepare the quiz with 5 questions
        List<String> states = new ArrayList<>(statesAndCapitals.keySet());
        Collections.shuffle(states);
        
        for (int i = 0; i < 5; i++) {
            String correctState = states.get(i);
            String correctCapital = statesAndCapitals.get(correctState);
            
            List<String> options = new ArrayList<>(statesAndCapitals.values());
            options.remove(correctCapital);
            Collections.shuffle(options);
            options = options.subList(0, 3);
            options.add(correctCapital);
            Collections.shuffle(options);

            quiz.addQuestion(new Question(correctState, options.toArray(new String[0]), correctCapital));
        }

        // One student takes the quiz
        System.out.println("Enter Student ID:");
        String studentId = sc.nextLine();
        Student student = new Student(studentId);
        student.takeQuiz(quiz);

        
        student.displayScore();
    }
}