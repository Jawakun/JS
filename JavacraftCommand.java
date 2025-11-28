package javacraft.command;

import java.util.List;


  Refactored command interface for Javacraft Engine.
  Original aa (deobfuscated ICommand equivalent)
  
  MOD COMPATIBILITY Public API preserved 100% for mod compatibility.
  All method signatures remain identical to support Reflection and Access Transformers.
 
public interface JavacraftCommand extends ComparableJavacraftCommand {
    
    String getCommandName();
    
    String getCommandUsage(JavacraftCommandSender sender);
    
    ListString getCommandAliases();
    
    void processCommand(JavacraftCommandSender sender, String[] args);
    
    boolean canCommandSenderUseCommand(JavacraftCommandSender sender);
    
    ListString addTabCompletionOptions(JavacraftCommandSender sender, String[] args);
    
    boolean isUsernameIndex(String[] args, int index);
    
     [PERFORMANCE] Default method for modern Java compatibility
    
      @deprecated This method is kept for mod compatibility only.
      Modders should use the modern Comparable interface instead.
     
    @Deprecated
    @Override
    default int compareTo(JavacraftCommand other) {
        return this.getCommandName().compareTo(other.getCommandName());
    }
}