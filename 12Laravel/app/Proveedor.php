<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Proveedor extends Model
{
    protected $table = 'proveedor';
    protected $fillable = ['name', 'empresa'];

    public function producto(){
        return $this->hasMany(
            'App\Producto', 'id_proveedor'
        );
    }
}
