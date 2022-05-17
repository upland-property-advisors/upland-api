package api.upland.me.world;

import java.util.List;

public class UplandFeatures {
    private final List<Integer> treasures;
    private final List<Integer> standardTreasures;
    private final List<Integer> collections;
    private final List<Integer> riotMode;
    private final List<Integer> construction;
    private final List<String> nftSwap;

    public UplandFeatures(List<Integer> treasures, List<Integer> standardTreasures, List<Integer> collections,
                          List<Integer> riotMode, List<Integer> construction, List<String> nftSwap) {
        this.treasures = treasures;
        this.standardTreasures = standardTreasures;
        this.collections = collections;
        this.riotMode = riotMode;
        this.construction = construction;
        this.nftSwap = nftSwap;
    }

    public List<Integer> getTreasures() {
        return treasures;
    }

    public List<Integer> getStandardTreasures() {
        return standardTreasures;
    }

    public List<Integer> getCollections() {
        return collections;
    }

    public List<Integer> getRiotMode() {
        return riotMode;
    }

    public List<Integer> getConstruction() {
        return construction;
    }

    public List<String> getNftSwap() {
        return nftSwap;
    }
}
