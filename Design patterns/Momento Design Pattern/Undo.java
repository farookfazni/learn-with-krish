import java.util.ArrayList;

public class Undo {

    ArrayList<UndoWords> undoWords = new ArrayList<>();

    public void addWord(UndoWords undoWord){
        undoWords.add(undoWord);
    }

    public ArrayList<UndoWords> getUndoWords() {
        return (ArrayList) undoWords.clone();
    }

    public UndoMemento save(){
        return new UndoMemento(getUndoWords());
    }

    public void revert(UndoMemento undoMemento){
        undoWords = undoMemento.getUndoWords();
    }

    @Override
    public String toString() {
        return "Undo{" +
                "UndoWords=" + undoWords +
                '}';
    }

    static class UndoMemento{

        ArrayList<UndoWords> undoWords;


        private ArrayList<UndoWords> getUndoWords() {
            return undoWords;
        }

        public UndoMemento(ArrayList<UndoWords> undoWords) {
            this.undoWords = undoWords;


        }
    }
}