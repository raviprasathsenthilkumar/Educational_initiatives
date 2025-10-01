package com.designpatterns.behavioral.command;

/**
 * Concrete Command - Write text to editor
 */
public class WriteCommand implements Command {
    private TextEditor editor;
    private String text;
    
    public WriteCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }
    
    @Override
    public void execute() {
        editor.write(text);
        System.out.println("  [Wrote: '" + text + "']");
    }
    
    @Override
    public void undo() {
        editor.delete(text.length());
        System.out.println("  [Undo Write]");
    }
}