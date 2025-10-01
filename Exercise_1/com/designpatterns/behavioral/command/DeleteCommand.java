package com.designpatterns.behavioral.command;

/**
 * Concrete Command - Delete text from editor
 */
public class DeleteCommand implements Command {
    private TextEditor editor;
    private int length;
    private String deletedText;
    
    public DeleteCommand(TextEditor editor, int length) {
        this.editor = editor;
        this.length = length;
    }
    
    @Override
    public void execute() {
        String content = editor.getContent();
        int startIndex = Math.max(0, content.length() - length);
        deletedText = content.substring(startIndex);
        editor.delete(length);
        System.out.println("  [Deleted: '" + deletedText + "']");
    }
    
    @Override
    public void undo() {
        editor.write(deletedText);
        System.out.println("  [Undo Delete: restored '" + deletedText + "']");
    }
}