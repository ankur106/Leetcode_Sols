import java.util.*;

class TextEditor {
    Deque<Character> left, right;

    public TextEditor() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void addText(String text) {
        for (char ch : text.toCharArray()) {
            left.addLast(ch);
        }
    }

    public int deleteText(int k) {
        int count = 0;
        while (!left.isEmpty() && count < k) {
            left.removeLast();
            count++;
        }
        return count;
    }

    public String cursorLeft(int k) {
        while (!left.isEmpty() && k-- > 0) {
            right.addFirst(left.removeLast());
        }
        return getLast10();
    }

    public String cursorRight(int k) {
        while (!right.isEmpty() && k-- > 0) {
            left.addLast(right.removeFirst());
        }
        return getLast10();
    }

    private String getLast10() {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = left.descendingIterator();
        int count = 0;
        while (it.hasNext() && count < 10) {
            sb.append(it.next());
            count++;
        }
        return sb.reverse().toString();
    }
}