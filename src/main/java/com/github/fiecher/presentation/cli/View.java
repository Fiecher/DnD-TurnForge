package com.github.fiecher.presentation.cli;

public class View {

    public void showWelcome() {
        showMessage("╭────────────────────────────────────────────╮");
        showMessage("│    DUNGEONS & DRAGONS: TURNFORGE CONSOLE   │");
        showMessage("╰────────────────────────────────────────────╯");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showSuccess(String message) {
        System.out.println("\n[INFO] SUCCESS: " + message);
    }

    public void showError(String message) {
        System.err.println("\n[INFO] ERROR: " + message);
    }

    public void showWarning(String message) {
        System.out.println("\n[INFO] WARNING: " + message);
    }

    public void showDivider() {
        System.out.println("\n----------------------------------------\n");
    }
}