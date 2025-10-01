package com.designpatterns.behavioral.command;

/**
 * Concrete Command - Paste text from clipboard
 */
public class PasteCommand implements Command {
    private TextEditor editor;
    private String textToPaste;
    private int lengthPasted;
    
    public PasteCommand(TextEditor editor, String textToPaste) {
        this.editor = editor;
        this.textToPaste = textToPaste;
    }
    
    @Override
    public void execute() {
        if (textToPaste != null) {
            editor.write(textToPaste);
            lengthPasted = textToPaste.length();
            System.out.println("  [Pasted: '" + textToPaste + "']");
        }
    }
    
    @Override
    public void undo() {
        editor.delete(lengthPasted);
        System.out.println("  [Undo Paste]");
    }
}