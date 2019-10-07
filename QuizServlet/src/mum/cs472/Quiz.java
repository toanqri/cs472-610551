package mum.cs472;

public class Quiz {

    private static final String[] questions = {
            "3, 1, 4, 1, 5", //pi
            "1, 1, 2, 3, 5", //fibonacci
            "1, 4, 9, 16, 25", //squares
            "2, 3, 5, 7, 11", //primes
            "1, 2, 4, 8, 16" //powers of 2
    };

    private static int[] answers = {9, 8, 36, 13, 32};

    private int currentQuestion;
    private int score;

    public Quiz() {
        this.currentQuestion = 0;
        this.score = 0;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNumberSequence() {
        return questions[currentQuestion];
    }

    public void checkAnswer(int answer) {
        if (answer == answers[currentQuestion]) {
            score++;
        }
        this.currentQuestion++;
    }
}
