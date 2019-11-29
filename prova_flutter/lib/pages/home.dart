import 'package:flutter/material.dart';
import 'package:prova_flutter/pages/quem_ganhou.dart';

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  int nos = 0;
  int eles = 0;

  maisEles() {
    setState(() {
      if(eles < 12){

        eles = eles + 1;
      }
      if (eles == 12) {
        Navigator.push(context, MaterialPageRoute(
          builder: (context) => QuemGanhou("Eles ganharam")
        ));
      }
    });
  }

  maisNos() {
    setState(() {
      if(nos < 12){
      nos = nos + 1;
      }
      if (nos == 12) {
        Navigator.push(context, MaterialPageRoute(
          builder: (context) => QuemGanhou("Nos ganhamos")
        ));
      }
    });
  }

  menosEles(){
    if(eles > 0){
      setState(() {
        eles = eles - 1;
      });
    }
  }

  menosNos(){
    if(nos > 0){
      setState(() {
        nos= nos - 1;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Meu Truco"),
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Padding(
              padding: EdgeInsets.all(24),
              child: Row(
              children: <Widget>[
                Expanded(
                    child:
                        Column(
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: <Widget>[Text("Nos"), Text("$nos")])
                          ),
                Expanded(
                    child:
                        Column(
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: <Widget>[Text("Eles"), Text("$eles")]))
              ],
            ),
            ),
            Padding(
              padding: EdgeInsets.all(24),
              child: Row(
              children: <Widget>[
                Expanded(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                  children: <Widget>[
                    FlatButton(
                      child: Text("+1"),
                      onPressed: maisNos,
                    ),
                    FlatButton(
                      child: Text("-1"),
                      onPressed: menosNos,
                    ),
                  ],
                )),
                Expanded(
                    child: Column(
                  children: <Widget>[
                    FlatButton(
                      child: Text("+1"),
                      onPressed: maisEles,
                    ),
                    FlatButton(
                      child: Text("-1"),
                      onPressed: menosEles,
                    ),
                  ],
                ))
              ],
            )
            ),
            Padding(
              padding: EdgeInsets.all(24),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  RaisedButton(
                    child: Text("Zerar"),
                    onPressed: (){
                      setState(() {
                        eles = 0;
                        nos = 0;
                      });
                    },
                  )
                ],
              ),
            )
          ],
        ));
  }
}
