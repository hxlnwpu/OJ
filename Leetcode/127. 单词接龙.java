/**
 * 方法1：广度优先搜索
 */
class Solution {
    Map<String,Integer> wordID = new HashMap<String,Integer>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      for (String word:wordList)
          addEdge(word);
      addEdge(beginWord);
      if(!wordID.containsKey(endWord))
          return 0;
      //记录从beginID到对应点的距离
      int[] dis = new int[nodeNum];
      Arrays.fill(dis,Integer.MAX_VALUE);
      int beginId = wordID.get(beginWord),endId = wordID.get(endWord);
      dis[beginId] = 0;
      Queue<Integer> que = new LinkedList<>();
      que.offer(beginId);
      while(!que.isEmpty())
      {
          int x = que.poll();
          if(x==endId)
              return dis[endId]/2+1;
          for(int it:edge.get(x))
          {
              if(dis[it]==Integer.MAX_VALUE)
              {
                  dis[it] = dis[x]+1;
                  que.offer(it);
              }
          }
      }
      return 0;

    }
    public void addWord(String word)
    {
        if(!wordID.containsKey(word))
        {
            wordID.put(word,nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(String word)
    {
        addWord(word);
        int id1 = wordID.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            char temp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordID.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = temp;
        }
    }
}

/**
 * 方法2：双向广度优先搜索
 */
class Solution {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }

        int[] disBegin = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        disBegin[beginId] = 0;
        Queue<Integer> queBegin = new LinkedList<Integer>();
        queBegin.offer(beginId);
        
        int[] disEnd = new int[nodeNum];
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        int endId = wordId.get(endWord);
        disEnd[endId] = 0;
        Queue<Integer> queEnd = new LinkedList<Integer>();
        queEnd.offer(endId);

        while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
            int queBeginSize = queBegin.size();
            for (int i = 0; i < queBeginSize; ++i) {
                int nodeBegin = queBegin.poll();
                if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                }
                for (int it : edge.get(nodeBegin)) {
                    if (disBegin[it] == Integer.MAX_VALUE) {
                        disBegin[it] = disBegin[nodeBegin] + 1;
                        queBegin.offer(it);
                    }
                }
            }

            int queEndSize = queEnd.size();
            for (int i = 0; i < queEndSize; ++i) {
                int nodeEnd = queEnd.poll();
                if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                }
                for (int it : edge.get(nodeEnd)) {
                    if (disEnd[it] == Integer.MAX_VALUE) {
                        disEnd[it] = disEnd[nodeEnd] + 1;
                        queEnd.offer(it);
                    }
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}
