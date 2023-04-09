public interface Enemy {
    protected String type;
    protected int vitality;
    public void attack(Player p);
    public void specAttack(Player p);
    public void defend();
    public String getType();
    public int getVitality();
}
