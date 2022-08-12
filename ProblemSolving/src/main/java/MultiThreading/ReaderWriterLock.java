//package MultiThreading;
//
//public class ReaderWriterLock {
//
//}
//
//read_lock() {
//	  mutex.lock();
//	  while (writer)
//	    unlocked.wait(mutex);
//	  readers++;
//	  mutex.unlock();
//	}
//
//	read_unlock() {
//	  mutex.lock();
//	  readers--;
//	  if (readers == 0)
//	    unlocked.signal_all();
//	  mutex.unlock();
//	}
//
//	write_lock() {
//	  mutex.lock();
//	  while (writer || (readers > 0))
//	    unlocked.wait(mutex);
//	  writer = true;
//	  mutex.unlock();
//	}
//
//	write_unlock() {
//	  mutex.lock();
//	  writer = false;
//	  unlocked.signal_all();
//	  mutex.unlock();
//	}