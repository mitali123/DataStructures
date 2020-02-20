/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twothreetreemitali;

/**
 *
 * @author manja
 */
public class TwoThreeTreeMitali {

    private boolean first;
    private int size;
    private boolean insertSuccess;
    private SubTree root;
    private boolean breakPt;

    private enum Nodes {
        LEFT, MIDDLE, RIGHT, DUMMY;
    }

    public TwoThreeTreeMitali() {
        first = false;
        insertSuccess = false;
        root = null;
        breakPt = false;
        size = 0;
    }

    private class Node {

    }

    private class SubTree extends Node {

        int data[];
        Node childNode[];
        int weight;

        SubTree() {
            data = new int[2];
            childNode = new Node[3];
            weight = 0;
        }

        void print() {

            if (weight == 1) {
                System.out.print("(-,-)");
            } else if (weight == 2) {
                System.out.print("(" + data[0] + ",-) ");
            } else {
                System.out.print("(" + data[0] + "," + data[1] + ") ");
            }
        }
    }

    private class LeafNode extends Node {

        int value;

        LeafNode(int value) {
            this.value = value;
        }

        void print() {
            System.out.print(value + " ");
        }
    }

    private void insertKey(int value) {
        Node[] arr = new Node[2];
        arr = insert(value, root);

        if (arr[1] == null) {
            root = (SubTree) arr[0];
        } else {
            SubTree treeRoot = new SubTree();
            treeRoot.childNode[0] = arr[0];
            treeRoot.childNode[1] = arr[1];
            treeUpd(treeRoot);
            root = treeRoot;
        }
    }

    private Node[] insert(int value, Node n) {

        Node arr[] = new Node[2];

        Node catchArray[] = new Node[2];

        SubTree t = null;

        if (n instanceof SubTree) {
            t = (SubTree) n;
        }

        if (root == null && !first) {
            first = true;

            SubTree newNode = new SubTree();
            t = newNode;
            t.childNode[0] = insert(value, t.childNode[0])[0];
            treeUpd(t);

            arr[0] = t;
            arr[1] = null;

        } else if (t != null && !(t.childNode[0] instanceof LeafNode)) {
            if (value < t.data[0]) {
                catchArray = insert(value, t.childNode[0]);
                t.childNode[0] = catchArray[0];

                if (breakPt) {
                    if (t.weight <= 2) {
                        breakPt = false;
                        t.childNode[2] = t.childNode[1];
                        t.childNode[1] = catchArray[1];
                        treeUpd(t);
                        arr[0] = t;
                        arr[1] = null;
                    } else if (t.weight > 2) {
                        SubTree newNode = new SubTree();
                        newNode.childNode[0] = t.childNode[1];
                        newNode.childNode[1] = t.childNode[2];
                        treeUpd(newNode);
                        t.childNode[1] = catchArray[1];
                        t.childNode[2] = null;
                        treeUpd(t);
                        arr[0] = t;
                        arr[1] = newNode;
                    }
                } else {
                    treeUpd(t);
                    arr[0] = t;
                    arr[1] = null;
                }
            } else if (value >= t.data[0] && (t.childNode[2] == null || value < t.data[1])) {
                catchArray = insert(value, t.childNode[1]);
                t.childNode[1] = catchArray[0];

                if (breakPt) {
                    if (t.weight <= 2) {
                        breakPt = false;
                        t.childNode[2] = catchArray[1];
                        treeUpd(t);
                        arr[0] = t;
                        arr[1] = null;
                    } else if (t.weight > 2) {
                        SubTree newNode = new SubTree();
                        newNode.childNode[0] = catchArray[1];
                        newNode.childNode[1] = t.childNode[2];
                        treeUpd(newNode);
                        t.childNode[2] = null;
                        treeUpd(t);
                        arr[0] = t;
                        arr[1] = newNode;
                    }
                } else {
                    treeUpd(t);
                    arr[0] = t;
                    arr[1] = null;
                }
            } else if (value >= t.data[1]) {
                catchArray = insert(value, t.childNode[2]);
                t.childNode[2] = catchArray[0];

                if (breakPt) {
                    if (t.weight > 2) {
                        SubTree newNode = new SubTree();
                        newNode.childNode[0] = catchArray[0];
                        newNode.childNode[1] = catchArray[1];
                        treeUpd(newNode);
                        t.childNode[2] = null;
                        treeUpd(t);
                        arr[0] = t;
                        arr[1] = newNode;

                    }
                } else {
                    treeUpd(t);
                    arr[0] = t;
                    arr[1] = null;
                }
            }
        } else if (t != null && t.childNode[0] instanceof LeafNode) {
            LeafNode l1 = null, l2 = null, l3 = null;
            if (t.childNode[0] != null && t.childNode[0] instanceof LeafNode) {
                l1 = (LeafNode) t.childNode[0];
            }
            if (t.childNode[1] != null && t.childNode[1] instanceof LeafNode) {
                l2 = (LeafNode) t.childNode[1];
            }
            if (t.childNode[2] != null && t.childNode[2] instanceof LeafNode) {
                l3 = (LeafNode) t.childNode[2];
            }

            if (t.weight <= 2) {
                // Simply find the place and insert the value
                if (t.weight == 1 && value > l1.value) {
                    LeafNode leaf = new LeafNode(value);
                    t.childNode[1] = leaf;
                } else if (t.weight == 1 && value < l1.value) {
                    LeafNode leaf = new LeafNode(value);
                    t.childNode[1] = l1;
                    t.childNode[0] = leaf;
                } else if (t.weight == 2 && value < l1.value) {
                    LeafNode leaf = new LeafNode(value);
                    t.childNode[2] = l2;
                    t.childNode[1] = l1;
                    t.childNode[0] = leaf;
                } else if (t.weight == 2 && value < l2.value && value > l1.value) {
                    LeafNode leaf = new LeafNode(value);
                    t.childNode[2] = l2;
                    t.childNode[1] = leaf;
                } else if (t.weight == 2) {
                    LeafNode leaf = new LeafNode(value);
                    t.childNode[2] = leaf;
                }

                treeUpd(t);
                arr[0] = t;
                arr[1] = null;
            } else if (t.weight > 2) {
                breakPt = true;
                if (value < l1.value) {
                    LeafNode leaf = new LeafNode(value);
                    SubTree newNode = new SubTree();
                    t.childNode[0] = leaf;
                    t.childNode[1] = l1;
                    t.childNode[2] = null;
                    treeUpd(t);
                    newNode.childNode[0] = l2;
                    newNode.childNode[1] = l3;
                    treeUpd(newNode);
                    arr[0] = t;
                    arr[1] = newNode;
                } else if (value >= l1.value && value < l2.value) {
                    LeafNode leaf = new LeafNode(value);
                    SubTree newNode = new SubTree();
                    t.childNode[1] = leaf;
                    t.childNode[2] = null;
                    treeUpd(t);
                    newNode.childNode[0] = l2;
                    newNode.childNode[1] = l3;
                    treeUpd(newNode);
                    arr[0] = t;
                    arr[1] = newNode;
                } else if (value >= l2.value && value < l3.value) {
                    LeafNode leaf = new LeafNode(value);
                    t.childNode[2] = null;
                    treeUpd(t);
                    SubTree newNode = new SubTree();
                    newNode.childNode[0] = leaf;
                    newNode.childNode[1] = l3;
                    treeUpd(newNode);
                    arr[0] = t;
                    arr[1] = newNode;
                } else if (value >= l3.value) {
                    LeafNode leaf = new LeafNode(value);
                    t.childNode[2] = null;
                    treeUpd(t);
                    SubTree newNode = new SubTree();
                    newNode.childNode[0] = l3;
                    newNode.childNode[1] = leaf;
                    treeUpd(newNode);
                    arr[0] = t;
                    arr[1] = newNode;
                }
            }
            insertSuccess = true;
        } else if (n == null) {
            insertSuccess = true;
            arr[0] = new LeafNode(value);
            arr[1] = null;
            return arr;
        }

        return arr;
    }

    private void treeUpd(SubTree t) {

        if (t != null) {
            if (t.childNode[2] != null && t.childNode[1] != null && t.childNode[0] != null) {

                t.weight = 3;
                t.data[0] = getValueForKey(t, Nodes.LEFT);
                t.data[1] = getValueForKey(t, Nodes.RIGHT);
            } else if (t.childNode[1] != null && t.childNode[0] != null) {
                t.weight = 2;
                t.data[0] = getValueForKey(t, Nodes.LEFT);
                t.data[1] = 0;
            } else if (t.childNode[0] != null) {
                t.weight = 1;
                t.data[1] = t.data[0] = 0;
            }
        }
    }

    private int getValueForKey(Node n, Nodes whichVal) {
        int value = -1;

        SubTree t = null;
        LeafNode l = null;
        if (n instanceof SubTree) {
            t = (SubTree) n;
        } else {
            l = (LeafNode) n;
        }

        if (l != null) {
            value = l.value;
        }
        if (t != null) {
            if (null != whichVal) {
                switch (whichVal) {
                    case LEFT:
                        value = getValueForKey(t.childNode[1], Nodes.DUMMY);
                        break;
                    case RIGHT:
                        value = getValueForKey(t.childNode[2], Nodes.DUMMY);
                        break;
                    case DUMMY:
                        value = getValueForKey(t.childNode[0], Nodes.DUMMY);
                        break;
                    default:
                        break;
                }
            }
        }

        return value;
    }

    private boolean search(int value, Node n) {
        boolean found = false;
        SubTree t = null;
        LeafNode l = null;
        if (n instanceof SubTree) {
            t = (SubTree) n;
        } else {
            l = (LeafNode) n;
        }

        if (t != null) {
            if (t.weight == 1) {
                found = search(value, t.childNode[0]);
            } else if (t.weight == 2 && value < t.data[0]) {
                found = search(value, t.childNode[0]);
            } else if (t.weight == 2 && value >= t.data[0]) {
                found = search(value, t.childNode[1]);
            } else if (t.weight == 3 && value < t.data[0]) {
                found = search(value, t.childNode[0]);
            } else if (t.weight == 3 && value >= t.data[0] && value < t.data[1]) {
                found = search(value, t.childNode[1]);
            } else if (t.weight == 3 && value >= t.data[1]) {
                found = search(value, t.childNode[2]);
            }
        } else if (l != null && value == l.value) {
            return true;
        }

        return found;
    }

    public boolean insert(int value) {
        boolean insert = false;
        breakPt = false;

        if (!search(value)) {
            insertKey(value);
        }

        if (insertSuccess) {
            // Increment the size and return success
            size++;
            insert = insertSuccess;
            insertSuccess = false;
        }
        return insert;
    }

    public boolean search(int value) {
        return search(value, root);
    }

    public static void main(String[] args) {
        TwoThreeTreeMitali t = new TwoThreeTreeMitali();
        t.insert(3);
        t.insert(7);
        t.insert(9);
        t.insert(23);
        t.insert(45);
        t.insert(15);
        t.insert(12);
        t.insert(55);
        t.insert(24);
        t.insert(13);
        t.insert(11);
        t.insert(8);
        t.insert(19);
        t.insert(4);
        t.insert(31);
        t.insert(35);
        t.insert(56);

        System.out.println(t);

        boolean success = t.search(19);
        if (success) {
            System.out.printf("Key found\n");
        } else {
            System.out.printf("Key not found");
        }
    }
}

