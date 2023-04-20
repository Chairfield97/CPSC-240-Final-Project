//inherited from abstractenemyfactory
public class GrizzlyFactory implements AbstractEnemyFactory {
    //return Enemy grizzly
    @Override
    public Enemy createEnemy() {
        return new Grizzly();
    }
}
