public class Application{
    public static void main(String[] args){
        CareUndo careUndo = new CareUndo(); // new object of care Taker
    Undo undo = new Undo();

    undo.addWord(new UndoWords("1stword"));
    undo.addWord(new UndoWords("2ndword"));

    careUndo.save(undo);
    System.out.println(undo);

    undo.addWord(new UndoWords("3rdword"));
    careUndo.save(undo);
    System.out.println(undo);

    undo.addWord(new UndoWords("4thword"));
    careUndo.save(undo);
    System.out.println(undo);

    careUndo.revert(undo);
    System.out.println(undo);

    careUndo.revert(undo);
    System.out.println(undo);
    }
}