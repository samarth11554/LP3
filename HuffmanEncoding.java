import java.util.*;
class HuffmanNode {
char character;
int frequency;
HuffmanNode left;
HuffmanNode right;
HuffmanNode(char character, int frequency) {
this.character = character;
this.frequency = frequency;
this.left = null;
this.right = null;
}
HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
this.character = '\0';
this.frequency = frequency;
this.left = left;
this.right = right;
}
}
class FrequencyComparator implements Comparator<HuffmanNode> {
public int compare(HuffmanNode a, HuffmanNode b) {
return a.frequency - b.frequency;
}
}
public class HuffmanEncoding {
public static HuffmanNode buildHuffmanTree(Map<Character, Integer>
frequencyMap) {
PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new
FrequencyComparator());
for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
}
while (pq.size() > 1) {
HuffmanNode left = pq.poll();
HuffmanNode right = pq.poll();
int sumFreq = left.frequency + right.frequency;
HuffmanNode parent = new HuffmanNode(sumFreq, left, right);
pq.add(parent);
}
return pq.poll();
}
public static void generateCodes(HuffmanNode root, String code, Map<Character,
String> huffmanCodeMap) {
if (root == null) return;
if (root.left == null && root.right == null && root.character != '\0') {
huffmanCodeMap.put(root.character, code);
}
generateCodes(root.left, code + "0", huffmanCodeMap);
generateCodes(root.right, code + "1", huffmanCodeMap);
}
public static void printHuffmanCodes(Map<Character, String> huffmanCodeMap) {
System.out.println("Character\tHuffman Code");
for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
System.out.println(entry.getKey() + "\t\t" + entry.getValue());
}
}
public static void main(String[] args) {
String text = "huffman encoding in java";
Map<Character, Integer> frequencyMap = new HashMap<>();
for (char c : text.toCharArray()) {
if (c == ' ') continue;
frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
}
HuffmanNode root = buildHuffmanTree(frequencyMap);
Map<Character, String> huffmanCodeMap = new HashMap<>();
generateCodes(root, "", huffmanCodeMap);
printHuffmanCodes(huffmanCodeMap);
StringBuilder encoded = new StringBuilder();
for (char c : text.toCharArray()) {
if (c == ' ') continue;
encoded.append(huffmanCodeMap.get(c));
}
System.out.println("\nEncoded Text:");
System.out.println(encoded.toString());
}
}
