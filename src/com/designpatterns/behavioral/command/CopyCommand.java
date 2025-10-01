package com.designpatterns.behavioral.command;

/**
 * Concrete Command - Copy text to clipboard
 */
public class CopyCommand implements Command {
    private TextEditor editor;
    private String copiedText;
    private String clipboard;
    
    public CopyCommand(TextEditor editor, String textToCopy) {
        this.editor = editor;
        this.copiedText = textToCopy;
    }
    
    @Override
    public void execute() {
        clipboard = copiedText;
        System.out.println("  [Copied: '" + clipboard + "']");
    }
    
    @Override
    public void undo() {
        clipboard = null;
        System.out.println("  [Undo Copy]");
    }
    
    public String getClipboard() {
        return clipboard;
    }
}