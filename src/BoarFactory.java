// inherited from abstractEnemy factory
public class BoarFactory implements AbstractEnemyFactory {
  //Create a new boar enemy
    @Override
    public Enemy createEnemy() {
        return new Boar();
    }
}
