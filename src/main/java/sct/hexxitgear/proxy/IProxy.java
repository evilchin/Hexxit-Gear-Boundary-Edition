package sct.hexxitgear.proxy;

import net.minecraft.util.text.ITextComponent;

public interface IProxy {

	public void registerKeybinds();

	public void setActionText(ITextComponent message);
}
