package com.es2.memento;

import java.util.HashMap;

public class BackupService
{
    private Server server;
    private HashMap<Integer,Memento> snapshots = new HashMap<>();
    private int contador = 0;

    public BackupService(Server server)
    {
        this.server = server;
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException
    {
        if(!snapshots.containsKey(snapshotNumber))
        {
            throw new NotExistingSnapshotException();
        }
        server.restore(snapshots.get(snapshotNumber));
    }

    public void takeSnapshot()
    {
        snapshots.put(contador, new Memento(server.getStudentNames()));
        contador ++;
    }
}

