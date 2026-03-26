public class GameLogic {

    private int left = 1;
    private int right = 100;
    private int guess;

    public GameLogic() {
        guess = (left + right) / 2;
    }

    // Method utama untuk menentukan langkah berdasarkan prediksi model
    public int binarySearch(String predictedClass) {
        if (predictedClass == null) return -1;

        switch (predictedClass.toLowerCase()) {
            case "higher":
                return guessHigher();
            case "lower":
                return guessLower();
            case "stop": // atau "correct" tergantung label model kamu
                return guessCorrect();
            default:
                return -1;
        }
    }

    // Mengecek apakah tebakan sudah benar
    public boolean isGuessCorrect(String predictedClass) {
        if (predictedClass == null) return false;

        return predictedClass.equalsIgnoreCase("stop"); 
        // ganti "stop" jika label model kamu berbeda
    }

    // Jika angka user lebih tinggi dari tebakan
    public int guessHigher() {
        left = guess + 1; // geser batas kiri
        guess = (left + right) / 2;
        return guess;
    }

    // Jika angka user lebih rendah dari tebakan
    public int guessLower() {
        right = guess - 1; // geser batas kanan
        guess = (left + right) / 2;
        return guess;
    }

    // Jika tebakan sudah benar
    public int guessCorrect() {
        return guess;
    }

    // Optional: getter kalau dibutuhkan
    public int getGuess() {
        return guess;
    }
}