package be.intecbrussel.service;

import be.intecbrussel.model.Key;
import be.intecbrussel.repository.IKeyRepository;
import be.intecbrussel.repository.KeyRepository;

public class KeyService implements IKeyService{
    private StorageService storageService = new StorageService();
    private IKeyRepository keyRepository = new KeyRepository();

    @Override
    public void add(Key key) {
        if(key.getStorage()!= null && key.getStorage().getId() == 0) {
            storageService.add(key.getStorage());
        }
        keyRepository.create(key);
    }

    @Override
    public Key get(Long aLong) {
        return keyRepository.read(Key.class, aLong);
    }

    @Override
    public void update(Key entity) {
        keyRepository.update(entity);
    }

    @Override
    public void delete(Long object) {
        keyRepository.delete(Key.class, object);
    }
}
