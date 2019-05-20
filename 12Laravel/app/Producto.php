<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Producto extends Model
{
    protected $table = 'producto';
    protected $fillable = [
        'name',
        'cantidad',
        'precio',
        'id_proveedor',
        'id_categoria'
    ];

    public function categoria(){
        return $this->belongTo(
            'App\Categoria', 'id_categoria'
        );
    }

    public function proveedor(){
        return $this->belongTo(
            'App\Proveedor', 'id_proveedor'
        );
    }
}
