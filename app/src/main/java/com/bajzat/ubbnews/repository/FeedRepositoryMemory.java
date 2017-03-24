package com.bajzat.ubbnews.repository;

import com.bajzat.ubbnews.model.FeedItem;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bjz on 3/23/2017.
 */
public class FeedRepositoryMemory implements Repository<String, FeedItem> {
    private HashMap<String, FeedItem> map;

    public FeedRepositoryMemory() {
        this.map = new HashMap<>();
    }

    @Override
    public void create(FeedItem obj) throws Exception {
        if(map.containsKey(obj.getGuid())){
            throw new Exception("This item already exists!");
        }
    }

    @Override
    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public void update(String id, FeedItem obj) {
        map.remove(id);
        map.put(id,obj);
    }

    @Override
    public Iterable<FeedItem> read() {
        return new ArrayList<>(map.values());
    }
}
