package ch.heigvd.examples.bittorrent;

import bt.Bt;
import bt.data.Storage;
import bt.data.file.FileSystemStorage;
import bt.dht.DHTConfig;
import bt.dht.DHTModule;
import bt.runtime.BtClient;
import bt.runtime.Config;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BitTorrent {

  public static void main(String... args) throws MalformedURLException {
    // enable multithreaded verification of torrent data
    Config config = new Config() {
      @Override
      public int getNumOfHashingThreads() {
        return Runtime.getRuntime().availableProcessors() * 2;
      }
    };

    // enable bootstrapping from public routers
    DHTModule dhtModule = new DHTModule(new DHTConfig() {
      @Override
      public boolean shouldUseRouterBootstrap() {
        return true;
      }
    });

    // get download directory
    Path targetDirectory = Paths.get(System.getProperty("user.home"), "Downloads");

    // create file system based backend for torrent data
    Storage storage = new FileSystemStorage(targetDirectory);

    // create client with a private runtime
    BtClient client = Bt.client()
        .config(config)
        .storage(storage)
        .torrent(new URL(args[0]))
        .autoLoadModules()
        .module(dhtModule)
        .stopWhenDownloaded()
        .build();

    // launch
    client.startAsync().join();
  }

}
