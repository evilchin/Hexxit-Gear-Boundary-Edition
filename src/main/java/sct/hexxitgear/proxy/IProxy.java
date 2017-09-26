package sct.hexxitgear.proxy;

import net.minecraft.util.text.ITextComponent;

public interface IProxy {

	public void registerHandlers();
	
	public void setActionText(ITextComponent message);
}
