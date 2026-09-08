import pytest
import fonctions as f

def test_1():
    assert f.puiss(2,3) == 8
    assert f.puiss(2,2) == 4

def test_2():
    assert f.puiss(-1,2) == 1
    assert f.puiss(-1,3) == -1
    assert f.puiss(-1,-1) == -1
    assert f.puiss(-1,-2) == 1
    assert f.puiss(-2,-1) == -0.5

def test_3():
    assert f.puiss(0,1) == 0
    assert f.puiss(0,2) == 0
    assert f.puiss(0,10) == 0

    with pytest.raises(ValueError):
        f.puiss(0,-1)

