public class GrizzlyFactory implements AbstractEnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new Grizzly();
    }
}
