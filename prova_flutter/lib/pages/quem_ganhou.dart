import 'package:flutter/material.dart';

class QuemGanhou extends StatefulWidget {
  String quem;
  @override
  _QuemGanhouState createState() => _QuemGanhouState();

  QuemGanhou(this.quem);
}

class _QuemGanhouState extends State<QuemGanhou> {
  String quemGanhou = "";

  @override
  Widget build(BuildContext context) {
    quemGanhou = widget.quem;
    return Container(
        color: Colors.cyan[50],
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Text("$quemGanhou", style: TextStyle(fontSize: 28)),
                ],
              ),
              
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  RaisedButton(
                    child: Text("voltar"),
                    onPressed: (){
                      Navigator.pop(context);
                    },
                  )
                ],
              )
            ],
          ),
        ));
  }
}
