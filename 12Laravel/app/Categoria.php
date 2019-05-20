<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Categoria extends Model
{
    protected $table = 'categoria';
    protected $fillable = ['name'];

    public function producto(){
        return $this-> hasMany(
            'App\Categoria', 'id_',
        );
    }
}
